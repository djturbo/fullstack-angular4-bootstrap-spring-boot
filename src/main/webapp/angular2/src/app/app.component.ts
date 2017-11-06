import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  private BASE_URL = 'http://localhost:8080';
  public submitted: boolean;
  roomsearch: FormGroup;
  rooms: Room[];
  request: ReserveRoomRequest;
  currentCheckInVal: string;
  currentCheckOutVal: string;

  constructor(private http: Http) { }

  ngOnInit(): void {
    this.roomsearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });
    const roomsearchValueChanges$ = this.roomsearch.valueChanges;
    roomsearchValueChanges$.subscribe(
      valueChange => {
        this.currentCheckInVal = valueChange.checkin;
        this.currentCheckOutVal = valueChange.checkout;
      }
    );
  }

  onSubmit = ({ value, valid }: { value: Roomsearch, valid: boolean }) => {
    console.log('AppComponent :: onSubmit :: value ', value);
    this.getAll().subscribe(
      rooms => {
        this.rooms = rooms;
      },
      err => {
        console.log('AppComponent :: onSubmit :: error: ', err);
      }
    );
  }

  reserveRoom(value: string) {
    console.log('AppComponent :: reserveRoom :: value: ', value);
    this.request = new ReserveRoomRequest(value, this.currentCheckInVal, this.currentCheckOutVal);
    this.createReservation(this.request);
  }

  getAll(): Observable<Room[]> {
    return this.http.get(this.BASE_URL + '/room/reservation/v1?checkin=' + this.currentCheckInVal + '&checkout=' + this.currentCheckOutVal)
      .map(this.mapRoom);
  }

  createReservation(body:ReserveRoomRequest){
    let bodyString = JSON.stringify(body);
    let headers = new Headers({'Content-Type': 'application/json'});
    let option = new RequestOptions({headers: headers});

    this.http.post(this.BASE_URL + '/room/reservation/v1', body, option)
    .subscribe(
      res => {
        console.log('res: ', res);
      },
    );
  }

  mapRoom = (response: Response) => {
    return response.json().content;
  }

}

export interface Roomsearch {
  checkin: string;
  checkout: string;
}

export interface Room {
  id: string;
  roomNumber: string;
  price: string;
  links: string;
}

export class ReserveRoomRequest {
  roomId: string;
  checkin: string;
  checkout: string;

  constructor(roomId: string, checkin: string, checkout: string) {
    this.roomId = roomId;
    this.checkin = checkin;
    this.checkout = checkout;
  }
}
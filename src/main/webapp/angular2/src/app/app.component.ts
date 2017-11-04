import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {


  public submitted: boolean;
  roomsearch: FormGroup;
  rooms: Room[];
  constructor() { }

  ngOnInit(): void {
    this.roomsearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });

    this.rooms = ROOMS;
  }

  onSubmit = ({ value, valid }: { value: Roomsearch, valid: boolean }) => {
    console.log('AppComponent :: onSubmit :: value ', value); 
  }

  reserveRoom(value: string){
    console.log("AppComponent :: reserveRoom :: value: ", value);
  }

}

export interface Roomsearch {
  checkin: string;
  checkout: string;
}

export interface Room {
  id: string;
  roomNumber: string;
  price:string;
  links:string;
}

var ROOMS:Room[] = [
  {
    "id" :        "38932123",
    "roomNumber": "409",
    "price":      "20",
    "links":      ""
  },
  {
    "id" :        "38932124",
    "roomNumber": "410",
    "price":      "22",
    "links":      ""
  },
  {
    "id" :        "38932125",
    "roomNumber": "411",
    "price":      "23",
    "links":      ""
  }
]
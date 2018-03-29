import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MessagesService } from '../service/messages.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  alertType: string = "";
  message: string = "";
  isDisplayed = false;

  constructor(private msService: MessagesService) { }

  ngOnInit() {

    this.alertType = this.msService.alertType;
    this.message = this.msService.message;
    this.isDisplayed = this.msService.isDisplayed;
    console.log("alertType : " + this.alertType);
    console.log("message : " + this.message);
    console.log("isDisplayed : " + this.isDisplayed);
  }

}

import { Injectable } from '@angular/core';

@Injectable()
export class MessagesService {

    isDisplayed = true;
    alertType = "";
    message = "";

    constructor(){}

    displayFailureMessage(message: string){
        this.message = message;
        this.alertType = "danger";
    }

    displaySuccessfullMessage(message: string){
        this.message = message;
        this.alertType = "success";
    }

    displayWarningMessage(message: string){
        this.message = message;
        this.alertType = "warning";
    }   
}
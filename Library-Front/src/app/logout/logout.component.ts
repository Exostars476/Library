import { Component, OnInit } from '@angular/core';
import { BackendService } from '../service/backend.service';
import { MessagesService } from '../service/messages.service';
import { DatashareService } from '../service/datashare.service';
import { Router } from '@angular/router';
import {LocalStorageService, LocalStorage} from 'ngx-webstorage';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

 @LocalStorage('me')
    boundAttribute;

  constructor(
    private backService: BackendService,
    private MessagesService: MessagesService,
    private dss: DatashareService,
    private router: Router,
    private storage: LocalStorageService) { }

  ngOnInit() {
  }

  logout() {
    this.backService.logout().subscribe(
      data => {
        this.backService.handleData(data);
         console.log(this.boundAttribute);
        this.storage.clear(this.storage.retrieve("me"));
        this.dss.loggedMember=null;
        this.router.navigate(['/home']);
      },
      error => {
        console.error(error.message);
        //messageService.displayFailureMessage(error.message);
      }
    );
  }
}

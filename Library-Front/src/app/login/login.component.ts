import { Component, OnInit, ComponentFactoryResolver } from '@angular/core';
import { IdentifiantsVM } from '../model/IdentifiantsVM';
import { BackendService } from '../service/backend.service';
import { MessagesService } from '../service/messages.service';
import { DatashareService } from '../service/datashare.service';
import { Router } from '@angular/router';
import { NavbarComponent } from '../navbar/navbar.component';
import { LocalStorageService } from 'ngx-webstorage';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  identifiants: IdentifiantsVM = {
    email: "",
    password: ""    
  };

  instantiatedComponent: any;

  constructor(
    private backService: BackendService,
    private MessagesService: MessagesService,
    private dss: DatashareService,
    private router: Router,
    private storage: LocalStorageService) { }

  ngOnInit() {
  }

  login() {
    this.backService.login(this.identifiants).subscribe(
      data => {
        this.backService.handleData(data);
        if (data.payload) {
          this.dss.loggedMember = data.payload;
          this.storage.store('me', data.payload);
          if(this.storage.retrieve("me").access == 1){
            this.router.navigate(['/administration']);
          }else{
            this.router.navigate(['/home']);
          }
        }
      },
      error => {
        console.error(error.message);
        //messageService.displayFailureMessage(error.message);
      }
    );
  }
}

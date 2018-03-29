import { Component, OnInit, Injectable } from '@angular/core';
import { BackendService } from '../service/backend.service';
import { MessagesService } from '../service/messages.service';
import { DatashareService } from '../service/datashare.service';
import { Router } from '@angular/router';
import { LocalStorageService, LocalStorage } from 'ngx-webstorage';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class LogoutService implements OnInit {

    constructor(
        private backService: BackendService,
        private MessagesService: MessagesService,
        private dss: DatashareService,
        private router: Router,
        private storage: LocalStorageService) { }

    ngOnInit() {
    }

    logout() {
        return this.backService.logout().subscribe(
            data => {
                this.backService.handleData(data);
                this.storage.clear("me");
                this.router.navigateByUrl('/login', { skipLocationChange: true }).then(() => {
                    this.dss.loggedMember = null;
                    this.router.navigate(['/home']);
                });
            },
            error => {
                console.error(error.message);
                //messageService.displayFailureMessage(error.message);
            }
        );
    }
}

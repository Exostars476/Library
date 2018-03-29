import { Component, OnInit } from '@angular/core';
import { DatashareService } from '../service/datashare.service';
import { LocalStorageService } from 'ngx-webstorage';
import { Router } from '@angular/router';

@Component({
  selector: 'app-administration',
  templateUrl: './administration.component.html',
  styleUrls: ['./administration.component.css']
})
export class AdministrationComponent implements OnInit {

  isAdmin = false;

  constructor(private router: Router,
    private storage: LocalStorageService) { }

  ngOnInit() {
    if(this.storage.retrieve('me')){
      if(this.storage.retrieve('me').access !== 1){  
        this.router.navigate(['/notAdmin']); 
      }
    }else{
      this.router.navigate(['/notConnected']); 
    }    
  }
}

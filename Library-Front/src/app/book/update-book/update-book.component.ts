import { Component, OnInit } from '@angular/core';
import { DatashareService } from '../../service/datashare.service';
import { LocalStorageService } from 'ngx-webstorage';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  isAdmin = false;

  constructor(private dss: DatashareService,
  private storage: LocalStorageService,
  private router: Router) { }

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

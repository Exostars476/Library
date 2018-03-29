import { Injectable } from '@angular/core';

@Injectable()
export class DatashareService {

  loggedMember: {
    access: number;
    address: string;
    city: string;
    email: string;
    firstName: string;
    memberLastName: string;
    password: string;
    phone: string;
    postalCode: string;
  }

  loggedMemberAdmin: {
    access: number;
    address: string;
    city: string;
    email: string;
    firstName: string;
    memberLastName: string;
    password: string;
    phone: string;
    postalCode: string;
  }

  navbarViewContainer: any;
  constructor() { }
  
}

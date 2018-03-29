import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarLoggedAdminComponent } from './navbar-logged-admin.component';

describe('NavbarLoggedAdminComponent', () => {
  let component: NavbarLoggedAdminComponent;
  let fixture: ComponentFixture<NavbarLoggedAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavbarLoggedAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarLoggedAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

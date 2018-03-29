import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IsNotAdminComponent } from './is-not-admin.component';

describe('IsNotAdminComponent', () => {
  let component: IsNotAdminComponent;
  let fixture: ComponentFixture<IsNotAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IsNotAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IsNotAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

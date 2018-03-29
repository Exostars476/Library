import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IsNotConnectedComponent } from './is-not-connected.component';

describe('IsNotConnectedComponent', () => {
  let component: IsNotConnectedComponent;
  let fixture: ComponentFixture<IsNotConnectedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IsNotConnectedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IsNotConnectedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

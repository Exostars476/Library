import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecBookComponent } from './rec-book.component';

describe('RecBookComponent', () => {
  let component: RecBookComponent;
  let fixture: ComponentFixture<RecBookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecBookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAccUnitComponent } from './add-acc-unit.component';

describe('AddAccUnitComponent', () => {
  let component: AddAccUnitComponent;
  let fixture: ComponentFixture<AddAccUnitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddAccUnitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAccUnitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOfAccUnitsComponent } from './list-of-acc-units.component';

describe('ListOfAccUnitsComponent', () => {
  let component: ListOfAccUnitsComponent;
  let fixture: ComponentFixture<ListOfAccUnitsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListOfAccUnitsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListOfAccUnitsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

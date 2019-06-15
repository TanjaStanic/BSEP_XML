import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOfAgentsComponent } from './list-of-agents.component';

describe('ListOfAgentsComponent', () => {
  let component: ListOfAgentsComponent;
  let fixture: ComponentFixture<ListOfAgentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListOfAgentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListOfAgentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

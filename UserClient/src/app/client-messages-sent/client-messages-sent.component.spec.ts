import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientMessagesSentComponent } from './client-messages-sent.component';

describe('ClientMessagesSentComponent', () => {
  let component: ClientMessagesSentComponent;
  let fixture: ComponentFixture<ClientMessagesSentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientMessagesSentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientMessagesSentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

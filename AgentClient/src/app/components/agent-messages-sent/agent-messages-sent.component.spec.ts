import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentMessagesSentComponent } from './agent-messages-sent.component';

describe('AgentMessagesSentComponent', () => {
  let component: AgentMessagesSentComponent;
  let fixture: ComponentFixture<AgentMessagesSentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentMessagesSentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentMessagesSentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

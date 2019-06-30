import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AccommodationsComponent } from './components/accommodations/accommodations.component';
import { CommentsComponent } from './components/comments/comments.component';
import { AddAccommodationComponent } from './components/add-accommodation/add-accommodation.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { MessagesComponent } from './components/messages/messages.component';
import { AddAccUnitComponent } from './components/add-acc-unit/add-acc-unit.component';
import { ListOfAccUnitsComponent } from './components/list-of-acc-units/list-of-acc-units.component';
import { AgentMessagesComponent } from './components/agent-messages/agent-messages.component';
import { AgentMessagesSentComponent } from './components/agent-messages-sent/agent-messages-sent.component';
import { ListReservationsComponent } from './components/list-reservations/list-reservations.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AccommodationsComponent,
    CommentsComponent,
    AddAccommodationComponent,
    HomePageComponent,
    MessagesComponent,
    AddAccUnitComponent,
    ListOfAccUnitsComponent,
    AgentMessagesComponent,
    AgentMessagesSentComponent,
    ListReservationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

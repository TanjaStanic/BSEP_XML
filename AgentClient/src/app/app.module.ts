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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AccommodationsComponent,
    CommentsComponent,
    AddAccommodationComponent,
    HomePageComponent,
    MessagesComponent
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

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AddAgentComponent } from './add-agent/add-agent.component';
import { CommentsComponent } from './comments/comments.component';
import { CertificatesComponent } from './certificates/certificates.component';
import { AddUserComponent } from './add-user/add-user.component';
import { ListOfUsersComponent } from './list-of-users/list-of-users.component';
import { ListOfAgentsComponent } from './list-of-agents/list-of-agents.component';
import { AddAccommodationComponent } from './add-accommodation/add-accommodation.component';
import { ListOfAccommodationsComponent } from './list-of-accommodations/list-of-accommodations.component';
import { AddCertificateComponent } from './add-certificate/add-certificate.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomePageComponent,
    AddAgentComponent,
    CommentsComponent,
    CertificatesComponent,
    AddUserComponent,
    ListOfUsersComponent,
    ListOfAgentsComponent,
    AddAccommodationComponent,
    ListOfAccommodationsComponent,
    AddCertificateComponent,
    
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

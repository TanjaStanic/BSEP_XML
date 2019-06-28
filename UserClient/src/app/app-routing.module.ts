import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ClientProfileComponent } from './client-profile/client-profile.component';
import { AccommodationDetailsComponent } from './accommodation-details/accommodation-details.component';
import { ClientMessagesComponent } from './client-messages/client-messages.component';
import { ClientMessagesSentComponent } from './client-messages-sent/client-messages-sent.component';

const routes: Routes = [
    {
    path: '',
    component: HomePageComponent
    },
    {
      path: 'homePage',
      component: HomePageComponent
    },
	{
      path: 'login',
      component: LoginComponent
    },
    {
      path: 'register',
      component: RegisterComponent
    },
    {
        path: 'clientProfile',
        component: ClientProfileComponent
      },
      {
          path: 'details',
          component: AccommodationDetailsComponent
      },
      {
          path: 'inbox',
          component: ClientMessagesComponent
      },
      {
          path: 'sent',
          component: ClientMessagesSentComponent
      }

	
	];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

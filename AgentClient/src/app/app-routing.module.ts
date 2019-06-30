import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { AddAccommodationComponent } from './components/add-accommodation/add-accommodation.component';
import { AccommodationsComponent } from './components/accommodations/accommodations.component';
import { CommentsComponent } from './components/comments/comments.component';
import { MessagesComponent } from './components/messages/messages.component';
import { AddAccUnitComponent } from './components/add-acc-unit/add-acc-unit.component';
import { ListOfAccUnitsComponent } from './components/list-of-acc-units/list-of-acc-units.component';
import { AgentMessagesComponent } from './components/agent-messages/agent-messages.component';
import { AgentMessagesSentComponent } from './components/agent-messages-sent/agent-messages-sent.component';



const routes: Routes = [   
   {
    path: 'login',
    component: LoginComponent
   }, 
   {
      path: '',
      component: HomePageComponent
    },
    {
      path: 'homePage',
      component: HomePageComponent
    },
    {
        path: 'accommodations',
        component: AccommodationsComponent
     },
    {
      path: 'addAccommodation',
      component: AddAccommodationComponent
    },
    {
      path: 'listOfAccUnits',
      component: ListOfAccUnitsComponent
    },
    {
        path: 'addAccUnit',
        component: AddAccUnitComponent
      },
      {
          path: 'inbox',
          component: AgentMessagesComponent
      },
      {
          path: 'sent',
          component: AgentMessagesSentComponent
      }

  ];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

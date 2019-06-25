import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AddAgentComponent } from './add-agent/add-agent.component';
import { CommentsComponent } from './comments/comments.component';
import { CertificatesComponent } from './certificates/certificates.component';
import { AddUserComponent } from './add-user/add-user.component';
import { AddAccommodationComponent } from './add-accommodation/add-accommodation.component';
import { ListOfUsersComponent } from './list-of-users/list-of-users.component';
import { ListOfAgentsComponent } from './list-of-agents/list-of-agents.component';
import { ListOfAccommodationsComponent } from './list-of-accommodations/list-of-accommodations.component';
import { AddCertificateComponent } from './add-certificate/add-certificate.component';
import { AccommodationDetailsComponent } from './accommodation-details/accommodation-details.component';





const routes: Routes = [
    {
      path: 'login',
      component: LoginComponent
    },
    
    {
      path: 'register',
      component: RegisterComponent
    },
    {
      path: 'homePage',
      component: HomePageComponent
    },
    {
      path: 'addAgents',
      component: AddAgentComponent
    },
    {
      path: 'comments',
      component: CommentsComponent
    },
    {
      path: 'certificates',
      component: CertificatesComponent
    },
    {
      path: 'addUser',
      component: AddUserComponent
    },
    {
      path: 'addAcc',
      component: AddAccommodationComponent
    },
    {
      path: 'listUsers',
      component: ListOfUsersComponent
    },
    {
      path: 'listAgents',
      component: ListOfAgentsComponent
    },
    {
      path: 'listAcc',
      component: ListOfAccommodationsComponent
    },
    {
        path: 'addCertificate',
        component: AddCertificateComponent
      },
    {
        path: 'accDetails',
        component: AccommodationDetailsComponent
      }
    
    ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

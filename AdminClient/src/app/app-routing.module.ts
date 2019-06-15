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
import { ListOfAccommodationsComponent } from './list-of-accommodations/list-of-accommodations.component';







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
      path: 'listAcc',
      component: ListOfAccommodationsComponent
    }
    
    ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

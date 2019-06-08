import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AddAgentComponent } from './add-agent/add-agent.component';
import { CommentsComponent } from './comments/comments.component';



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
    }
    
    ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

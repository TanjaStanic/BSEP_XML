import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { AddAccommodationComponent } from './components/add-accommodation/add-accommodation.component';
import { AccommodationsComponent } from './components/accommodations/accommodations.component';
import { CommentsComponent } from './components/comments/comments.component';

const routes: Routes = [   {
    path: 'login',
    component: LoginComponent
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
      path: 'comments',
      component: CommentsComponent
    }

  ];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

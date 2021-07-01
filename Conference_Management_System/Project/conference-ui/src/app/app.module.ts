import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {EnterComponent} from './enter/enter.component';
import {PaperSubmitComponent} from './paper-submit/paper-submit.component';
import {AdminComponent} from './admin/admin.component';
import {ChairComponent} from './chair/chair.component';
import {ListenerComponent} from './listener/listener.component';
import {ConferenceUpdateComponent} from './chair/conference-update/conference-update.component';
import {SectionNewComponent} from './chair/section-new/section-new.component';
import {PcmemberComponent} from './pcmember/pcmember.component';
import {ReviewPaperComponent} from './pcmember/review-paper/review-paper.component';
import {Paper} from './paper';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    EnterComponent,
    PaperSubmitComponent,
    AdminComponent,
    ChairComponent,
    ListenerComponent,
    ConferenceUpdateComponent,
    SectionNewComponent,
    PcmemberComponent,
    ReviewPaperComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'register',
        component: RegisterComponent
      },
      {
        path: '',
        component: LoginComponent
      },
      {
        path: 'enter',
        component: EnterComponent
      },
      {
        path: 'submit/:id',
        component: PaperSubmitComponent
      },
      {
        path: 'admin',
        component: AdminComponent
      },
      {
        path: 'chair',
        component: ChairComponent
      },
      {
        path: 'chair/:id',
        component: ChairComponent
      },
      {
        path: 'listener',
        component: ListenerComponent
      },
      {
        path: 'pcmember',
        component: PcmemberComponent
      },
      {
        path: 'review',
        component: ReviewPaperComponent,
      },
      {
        path: 'chair-update-conference',
        component: ConferenceUpdateComponent
      },
      {
        path: 'chair-sections',
        component: SectionNewComponent
      }
    ]),
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

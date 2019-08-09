import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { UpdateAccountClass } from './app.addAccount';
import { FormsModule} from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { RouterModule,Routes } from '@angular/router';
import { SearchClass } from './app.search';
import { AccountViewClass } from './app.AccountView';
import { TransferMoneyClass } from './TransferMoney';

    const routes: Routes = [
        { path: '', redirectTo: 'Account', pathMatch: 'full' },
       // { path: 'Account', component: CustomersListComponent },
        { path: 'add', component:UpdateAccountClass },//SearchClass
        { path: 'search', component:SearchClass },//CustomerListClass
        {  path: 'find', component:AccountViewClass } ,
        { path: 'tmoney', component:TransferMoneyClass }
      //  { path: 'findbyage', component: SearchCustomersComponent },
       // {path:'operation', component: OperationComponent},
        
    ];

@NgModule({
    imports: [
        BrowserModule, RouterModule.forRoot(routes),HttpClientModule,FormsModule    
    ],
    
    declarations: [
        AppComponent, UpdateAccountClass, SearchClass, AccountViewClass, TransferMoneyClass
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }
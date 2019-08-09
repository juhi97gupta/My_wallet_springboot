import { Component, Input, OnInit } from "@angular/core";
import { Account } from "./app.Account";
import { AccountService } from "./app.AccountServiceClass";



@Component({
    selector: 'add-comp',
    templateUrl: 'addAccount.html'
})

export class UpdateAccountClass implements OnInit{
  ob: Account = new Account();
  submitted = false;
constructor(private  service: AccountService){}
//@Input() ob: Account;

    
ngOnInit() {
}
AddData(){
  this.service. createAccount(this.ob)
  .subscribe(data => console.log(data), error => console.log(error));
this.ob = new Account();
}

newCustomer(): void {
  this.submitted = false;
  this.ob = new Account();
}

onSubmit() {
  this.submitted = true;
  this.AddData();
}
}
  
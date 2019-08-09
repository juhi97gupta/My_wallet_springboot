
import { Component, OnInit } from "@angular/core";
import { Account } from "./app.Account";
import { AccountService } from "./app.AccountServiceClass";
import { Observable } from 'rxjs';

@Component({
    selector: 'list-comp',
    templateUrl: 'viewAll.html'
})

export class AccountViewClass implements OnInit{

    accounts: Observable<Account[]>;

    constructor(private service: AccountService) { }

    ngOnInit() {
        this.reloadData();
      }
      reloadData() {
        this.accounts = this.service.getCustomersList();
        console.log(this.accounts)
      }

}

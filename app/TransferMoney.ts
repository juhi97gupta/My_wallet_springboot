import { Component, OnInit } from "@angular/core";
import { Account } from "./app.Account";
import { AccountService } from "./app.AccountServiceClass";




@Component({
    selector: 'trnsfr-comp',
    templateUrl: 'transfer.html'
})

export class TransferMoneyClass implements OnInit {
    constructor(private service: AccountService) { }
    from:any
    to:any
    amount:any
    //ob: Account = new Account();
    ngOnInit() {
        
      }
      transferMoney()
      {
        this.service.transferMoney(this.from, this.to, this.amount)
        .subscribe(data => console.log(data), error => console.log(error));
     
      }
        
    }

import { Component, OnInit } from '@angular/core';
import {User} from "../../dtos/user";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();
  failed: boolean;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  login(): void{
    this.authService.login(this.user).subscribe(
      (result)=>{
        this.failed = !result;
      }
    );
  }

}

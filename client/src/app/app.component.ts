import { Component, ViewChild } from '@angular/core';
import { BreakpointObserver } from '@angular/cdk/layout';
import { MatSidenav } from '@angular/material/sidenav';
import { UserService } from './services/user.service';
import { ScrollAnimationService } from './services/scroll-animation.service';
import { delay, filter } from 'rxjs/operators';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Vacation Dashboard';

  showCart = true;
  password: string = '';
  isAdmin: boolean = true;

  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;

  constructor(
    private observer: BreakpointObserver,
    private userService: UserService,
    private scrollAnimationService: ScrollAnimationService
  ) {
    this.isAdmin = this.userService.isAdmin(); // Set the isAdmin property based on the user role
  }

  ngAfterViewInit() {
    this.observer.observe(['(max-width: 800px)']).subscribe((res) => {
      if (res.matches) {
        this.sidenav.mode = 'over';
        this.sidenav.close();
      } else {
        this.sidenav.mode = 'side';
        this.sidenav.open();
      }
    });

    this.scrollAnimationService.initScrollAnimations();
  }
  login() {
    if (this.userService.validatePassword(this.password)) {
      this.userService.setUserRole('admin');
      this.isAdmin = true;
    } else {
      alert('Invalid password');
    }
  }
}

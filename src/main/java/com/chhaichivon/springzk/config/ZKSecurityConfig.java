package com.chhaichivon.springzk.config;



//@Configuration
//@EnableWebSecurity
//public class ZKSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.sessionManagement().sessionFixation().none();
//		http.authorizeRequests()
//			.antMatchers(
//					"/zkau*",				// <--- for zk ajax (internal)
//					"/login*", "/logout",	// <--- for login/logout
//					"/js/**", 	// <--- static resources...
//					"/css/**",
//					"/bootstrap/**",
//					"/img/**",
//					"/static/**"
//					)
//			.permitAll().anyRequest().authenticated().and()
//			.headers().frameOptions().disable().and()
//			.formLogin().permitAll().defaultSuccessUrl("/testVM.zul", true).and() // this redirect allways to testVM.zul page
//			.logout().permitAll().and()
//			.csrf().disable();
//	}
//
//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		// testing login user uuu / ppp
//        auth.inMemoryAuthentication().withUser("uuu").password("ppp").roles("USER");
//    }
//
//}

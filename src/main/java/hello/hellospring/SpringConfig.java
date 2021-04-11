package hello.hellospring;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;

/**
 * 
 * @author 유재헌
 * 내용 : 스프링 DI 설정 Class
 * @AutoWired를 통한 자동으로 Component Scan이 아닌
 * 자바 코드로 DI 설정하는 Class 이다.
 */
@Configuration
public class SpringConfig {

	private final MemberRepository memberRepository;
	
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
//	private EntityManager em;
//	
//	public SpringConfig(EntityManager em) {
//		this.em = em;
//	}
	
//	private DataSource dataSource;
//	
//	public SpringConfig(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
//		return new MemberService(memberRepository());
	}
	
//	@Bean
//	public MemberRepository memberRepository() {
//		//개방-폐쇄 원칙(OCP, Open-Closed Principle) : 확장에는 열려 있고, 수정, 변경에는 닫혀있다.
//		//기존 코드를 전혀 손대지 않고, 설정만으로 구현 클래스를 변경할 수 있다.
//		
//		return new MemoryMemberRepository();
//		return new JdbcMemberRepository(dataSource);
//		return new JdbcTemplateMemberRepository(dataSource);
//		return new JpaMemberRepository(em);
//	}
}

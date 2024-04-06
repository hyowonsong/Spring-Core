package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    // 참조형 객체
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /*첫 번째
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
     */

    // 생성자 주입
    // 설계 변경으로 orderServiceImpl 은 FixDiscountPolicy 를 의존하지 않는다.
    // 단지 DiscountPolicy 인터페이스만 의존한다.

    // 여기 있는 Autowired 생략 가능
    // 롬복 라이브러리 @RequiredArgsConstructor 사용하면 아래 전부 생략가능

    /*
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
     */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findByID(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

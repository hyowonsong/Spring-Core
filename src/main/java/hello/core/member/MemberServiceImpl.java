package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    /* 처음에는 구현기능에도 의존 했었다. 이것을 해결하기 위해 인터페이스에만 의존할 수 있도록 수정
    private final MemberRepository memberRepository = new MemoryMemberRepository();
     */
    private final MemberRepository memberRepository;

    // 생성자 주입 추가
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findByID(memberId);
    }
}

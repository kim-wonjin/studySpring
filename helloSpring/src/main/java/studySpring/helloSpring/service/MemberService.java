package studySpring.helloSpring.service;

import studySpring.helloSpring.domain.Member;
import studySpring.helloSpring.repository.MemberRepository;
import studySpring.helloSpring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// cmd + shift + t => Test 자동생성
public class MemberService {

    private final MemberRepository memberRepository;

    // Test 에서 memberRepository 를 중복으로 사용하지 않기 위함 (외부에서 넣어줌 => dependency injection)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    * 회원 가입
     */
    public Long join(Member member) {

        validateDuplicateMember(member); // 중복된 회원이름 검증 => cmd + opt + M -> extract method
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())  // 반환값이 Optional 이기 때문에 여러 메소드 사용가능
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원 이름입니다");
            });
    }

    /*
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

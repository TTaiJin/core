package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    void vip_o() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    void vip_x() {
        // given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(0);
    }

}
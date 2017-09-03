package cc.youqu8.humor.demo.proxy;

/**
 * @author panyi on 17-9-1.
 * @since V0.0.1
 */
public class Test {
    public static void main(String[] args) {
        Ball bind = (Ball)new GeneralJdkProxy().bind(new FootBall());
        bind.play();

        Ball bind2 = (Ball)new GeneralJdkProxy().bind(new BaseketBall());
        bind2.play();
        System.out.println("*****************************************************");
        FootBall bind1 = (FootBall)new GeneralCglibProxy().bind(new FootBall());
        bind1.play();
    }
}

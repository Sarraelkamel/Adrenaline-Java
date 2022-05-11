package API;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author NMEDIA
 */
public class sendSMS {
public static final String ACCOUNT_SID = System.getenv("AC6d4af82cb690cab36b41a0be953fd216");
    public static final String AUTH_TOKEN = System.getenv("15db71e6aeb42ae3950aa4c6916550dd");
   

    public static void sendSMS() {
        Twilio.init("AC6d4af82cb690cab36b41a0be953fd216", "15db71e6aeb42ae3950aa4c6916550dd");
        Message message = Message.creator(new PhoneNumber("+21650590106"),
                new PhoneNumber("+19896583817"),
                "Dear user, we're happy to inform you that a new event has been announced, checkout our app to find out more!").create();
        System.out.println(message.getSid());
       
    }

}

package io.renren.modules.account.utils;

import io.renren.common.exception.RRException;
import io.renren.common.utils.Constant;
import io.renren.modules.account.entity.WorkerAccountInfoEntity;
import io.renren.modules.account.webclient.UploadBankData;
import io.renren.modules.account.webclient.UploadBankDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 *银行工资发放系统的工具类
 */
public class BankUtil {

    private static Logger logger = LoggerFactory.getLogger(BankUtil.class);

    /**
     * 银行工资上传接口的调用
     * @param methodName 执行的方法名
     * @param xmlPara   传送的mal
     * @return
     */
    public static String uploadBankData(String methodName,String... xmlPara) {
        UploadBankDataService uploadBankDataService = new UploadBankDataService();
        UploadBankData uploadBankData =uploadBankDataService.getUploadBankDataPort();
        Class<? extends UploadBankData> aClass = uploadBankData.getClass();
        String resultMessage = "";
        try {

            /*验证个人在项目中是否存在，需要两个参数；其他情况均为一个参数*/
            if(xmlPara.length==1){
                Method method = aClass.getDeclaredMethod(methodName,String.class,String.class);
                resultMessage = (String)method.invoke(uploadBankData,xmlPara[0],Constant.BankAccount.PLAT_PASSWORD.getValue());
            }else{
                Method method = aClass.getDeclaredMethod(methodName,String.class,String.class,String.class);
                resultMessage = (String)method.invoke(uploadBankData,xmlPara[0],xmlPara[1],Constant.BankAccount.PLAT_PASSWORD.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException("方法执行报错");
        }
        return resultMessage;
    }


    /**
     * 将bean按照jaxb注解转换为xml字符串并且发送webservice请求获取数据
     * @param obj
     * @param load
     * @return
     * @throws JAXBException
     */
    public static String BeanToXml(Object obj,Class<?> load) {
        try {
            JAXBContext context = JAXBContext.newInstance(load);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            logger.info("BankUtil:--requestData--"+writer.toString());
            return writer.toString();//bean转为xml
        }catch (JAXBException e){
            throw new RRException("jaxb执行报错");
        }
    }
}

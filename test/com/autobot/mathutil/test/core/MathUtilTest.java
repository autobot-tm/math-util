/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobot.mathutil.test.core;

import com.autobot.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author bo
 */
public class MathUtilTest {
    //đây là class sẽ sử dụng các hàm của thư viện/framework JUnit
    //để kiểm thử/kiểm tra code chính - hàm tínhGiaiThừa() bên class core.MathUtil
    //viết code để test code chính bên kia!!!

    //có nhiều quy tắc đặt tên hàm kiểm thử
    //nhưng thường sẽ là nói lên mục đích của các case/tình huống kiểm thử
    //tình huống xài hàm theo kiểu thành công và thất bại!!!
    //hàm dưới đây là tình huống test hàm chạy thành công, trả về ngon
    //ta sẽ xài hàm kiểu well - đưa 5!, 6!, hok chơi đưa -5!, -30!
    //@Test JUnit sẽ phối hợp JVM để chạy hàm này
    //@Test phía hậu trường chính là public static void main()
    //Có nhiều @Test ứng với nhiều case khác nhau để kiểm thử hàm tính giai thừa
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        int n = 0; //test thử tình huống tử tế đầu vào, mày phải chạy đúng
        long expected = 1; //hy vọng rằng 0! = 1

        //long actual = ;// gọi hàm cần test bên core/ app chính/code chính
        long actual = MathUtil.getFactorial(n);

        //so sánh expected vs. actual dùng xanh xanh đỏ đỏ, framework
        Assert.assertEquals(expected, actual);

        //gộp thêm vài case thành công/đưa đầu vào ngon!!! hàm phải tính ngon
        Assert.assertEquals(1, MathUtil.getFactorial(1)); //tui mún 1! == 1
        Assert.assertEquals(2, MathUtil.getFactorial(2)); //tui mún 2! == 2 
        Assert.assertEquals(6, MathUtil.getFactorial(3)); //tui mún 3! == 6
        Assert.assertEquals(24, MathUtil.getFactorial(4));//tui mún 4! == 24
        Assert.assertEquals(120, MathUtil.getFactorial(5));//tui mún 5! == 120
        Assert.assertEquals(720, MathUtil.getFactorial(6));//tui mún 6! == 720
    }

    //hàm getF() ta thiết kế có 2 tình huống xử lí
    //1. đưa data tử tế trong [0..20] -> tính đúng dc n! - done
    //2. đưa data vào cà chớn, âm, > 20; THIẾT KẾ CỦA HÀM LÀ NÉM RA NGOẠI LỆ
    //TAO KÌ VỌNG NGOẠI LỆ XUẤT HIỆN KHI N<0 || N>20
    //rất mong ngoại lệ xuất hiện với n cà chớn này
    //nếu hàm nhận vào n < 0 hoặc n > 20 và hàm ném ra ngoại lệ
    //HÀM CHẠY ĐÚNG NHƯ THIẾT KẾ -> XANH PHẢI XUẤT HIỆN
    //nếu hàm nhận vào n<0 và n>20 và hàm éo ném ra ngoại lệ
    //sure, HÀM CHẠY SAI THIẾT JE61, SAI KÌ VỌNG, MÀU ĐỎ
    //Test case:
    //input: -5 
    //expected: IllegalArgumentExeption xuất hiện
    //tình huống bất thường, ngoại lệ, ngoài dự tính, dữ liệu
    //là những thứ ko thể đo lường so sánh theo kiểu value
    //mà chỉ có thể đo lường bằng cách chúng có xuất hiện hay ko
    //assertEquals() ko dùng để so sánh 2 ngoại lệ
    //      equals() là bằng nhau hay ko trên value!!!
    //MÀU ĐỎ, DO HÀM ĐÚNG LÀ CÓ NÉM NGOẠI LỆ THẬT SỰ
    //        NHƯNG KO PHẢI LÀ NGOẠI LỆ NHƯ KÌ VỌNG - THỰC SỰ KÌ VỌNG SAI
    //        KO PHẢI HÀM NÉM SAI
//    @Test(expected = NumberFormatException.class)
//    public void testGetFactorialGivenWrongArgumentThrowsException() {
//        MathUtil.getFactorial(-5); //hàm @Test chạy, hay hàm getF() chạy
//                                   //sẽ ném về ngoại lệ NumberFormat...
//    }    
    //(1)
    //Hàm ném đúng ngoại lệ => XANH
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialGivenWrongArgumentThrowsException() {
        MathUtil.getFactorial(-5);
    }

    //(2)
    //cách khác bắt ngoại lệ xuất hiện, viết tự nhiên hơn!!!
    //xài lambda
    //Test case: hàm sẽ ném về ngoại lệ nếu nhận vào 21
    //tui cần thấy màu xanh khi chơi với 21!
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_LambdaVersion() {

        //Assert.assertThrows(tham số 1: loại ngoại lệ mún so sánh,
        //tham số 2: đoạn code chạy văng ra ngoại runnable;
        //Assert.assertThrows(IllegalArgumentException.class,
        //      () -> MathUtil.getFactorfial(-5));  // netbean 12 13
        //MathUtil.getFactorial(-5);
    }

    //Bắt ngoại lệ, xem hàm có ném về ngoại lệ hay ko khi n cà chớn
    //có ném, tức là hàm chạy đúng thiết kế -> xanh
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_TryCatch() {

        //chủ động kiểm soát ngoại lệ!!!
        try {
            MathUtil.getFactorial(-5);
        } catch (Exception e) {
            //bắt try-cacth là JUnit sẽ ra xanh do đã chủ động kiểm soát ngoại lệ
            //nhưng ko chắc ngoại lệ mình cần có xuất hiện hay ko???
            //có đoạn code kiểm soát đúng ngoại lệ IllegalArgumentException xh
            Assert.assertEquals("Invalid argument. N must be between 0..20", 
                            e.getMessage());
        }
        
    }
}

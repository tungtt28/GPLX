package com.example.project.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project.R;

public class Meo_Ly_Thuyet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meo_ly_thuyet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Đặt nội dung cho TextView
        TextView textViewLyThuyet = findViewById(R.id.textViewLyThuyet);
        textViewLyThuyet.setText(getLyThuyetText());
    }

    private String getLyThuyetText() {
        return "I. CÁC KHÁI NIỆM CƠ BẢN\n" +
                "1. Phần đường xe chạy: Là phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại.\n" +
                "2. Làn đường: chia theo chiều dọc, có bề rộng đủ cho xe chạy an toàn.\n" +
                "3. Khổ giới hạn đường bộ: chiều cao, chiều rộng, hàng hóa xếp trên xe.\n" +
                "4. Dải phân cách: phân chia phần đường xe cơ giới, xe thô sơ.\n" +
                "• Gồm hai loại: cố định và di động.\n" +
                "5. Người lái xe: là người điều khiển xe cơ giới.\n" +
                "6. Đường ưu tiên: được các phương tiện nhường đường.\n" +
                "7. Phương tiện giao thông cơ giới đường bộ: kể cả xe máy điện, các loại xe tương tự.\n" +
                "8. Phương tiện giao thông thô sơ đường bộ: kể cả xe đạp máy, các loại xe tương tự.\n" +
                "9. Phương tiện tham gia giao thông đường bộ: cơ giới, thô sơ, xe máy chuyên dùng.\n" +
                "10. Người điều khiển phương tiện tham gia giao thông: người điều khiển xe cơ giới, xe thô sơ, xe máy chuyên dùng.\n" +
                "11. Người tham gia giao thông:\n" +
                "• Người sử dụng phương tiện.\n" +
                "• Dẫn dắt súc vật, người đi bộ.\n" +
                "12. Người điều khiển giao thông:\n" +
                "• Cảnh sát giao thông.\n" +
                "• Người được giao nhiệm vụ hướng dẫn giao thông.\n" +
                "13. Dừng xe: đứng yên tạm thời.\n" +
                "14. Đổ xe: đứng yên không giới hạn thời gian.\n" +
                "\n" +
                "II. QUY TẮC GIAO THÔNG ĐƯỜNG BỘ\n" +
                "1. Hiệu lệnh của người điều khiển giao thông:\n" +
                "• Tay giơ thẳng đứng: tất cả dừng lại.\n" +
                "• Hai tay hoặc một tay giơ ngang: trước sau dừng lại, trái phải được đi.\n" +
                "2. Khi sử dụng GPLX đã khai báo mất: bị tước GPLX 5 năm.\n" +
                "3. Trong đô thị và khu đông dân cư:\n" +
                "• Không được bấm còi từ 22 giờ tối đến 5 giờ sáng.\n" +
                "• Không được sử dụng đèn chiếu xa.\n" +
                "• Chỉ được báo hiệu xin vượt bằng đèn từ 22 giờ đến 5 giờ sáng.\n" +
                "• Chỉ được quay đầu xe nơi đường giao nhau, nơi có biển báo quay đầu xe.\n" +
                "4. Nhường đường tại nơi giao nhau.\n" +
                "• Không có biển báo hiệu đi theo vòng xuyến nhường đường bên phải.\n" +
                "• Có biển báo hiệu đi theo vòng xuyến nhường đường bên trái.\n" +
                "5. Xe quá tải trọng, quá khổ khi lưu thông trên đường: phải được cơ quan quản lý đường bộ có thẩm quyền cấp phép.\n" +
                "6. Khi đỗ xe ô tô sát lề đường hè phố phái bên phải:\n" +
                "• Cách lề, hè phố không quá 0.25 m.\n" +
                "• Cách xe ô tô đang đỗ phía bên kia đường tối thiểu 20m.\n" +
                "7. Vạch nét liền không được đè vạch, vạch nét đứt được đè vạch.\n" +
                "8. Vạch màu vàng phân chia các làn xe ngược chiều; vạch màu trắng phân chia các làn xe chạy cùng chiều.\n" +
                "\n" +
                "III. HOẠT ĐỘNG VẬN TẢI ĐƯỜNG BỘ\n" +
                "1. Thời gian làm việc vủa người lái xe ô tô: không quá 10h trên ngày, không lái liên tục quá 4h.\n" +
                "2. Quyền và nghĩa vụ của hành khách: được miễn phí cước hành lý ≤ 20 kg.\n" +
                "3. Hàng siêu trường, siêu trọng: kích thướt hoặc trọng lượng vượt quá giới hạn quy định nhưng không thể tháo rời được.\n" +
                "4. Giấy phép lái xe:\n" +
                "• Hạng A1: xe mô tô 2 bánh có dung tích xy lanh từ 50 cm3 đến dưới 175 cm3, xe mô tô 3 bánh dùng cho người khuyết tật.\n" +
                "• Hạng A2: xe mô tô 2 bánh có dung tích xy lanh từ 175 cm3 trở lên và hạng A1.\n" +
                "• Hạng A3: xe mô tô 3 bánh và hạng A1.\n" +
                "• Hạng A4: máy kéo nhỏ có trọng tải đến 1.000 kg.\n" +
                "• Hạng B1: chở người đến 9 chổ, tải dưới 3,5 T (không được kinh doanh vận tải).\n" +
                "• Hạng B1 tự dộng: ô tô tự động chở người đến 9 chổ, tải tự động dưới 3,5 T (không được kinh doanh vận tải), ô tô dùng cho người khuyết tật.\n" +
                "• Hạng B2: chở người đến 9 chổ, tải dưới 3,5 T.\n" +
                "• Hạng C: chở người đến 9 chổ, tải trên 3,5 T.\n" +
                "• Hạng D: chở người từ 10-30 chỗ\n";
    }
}

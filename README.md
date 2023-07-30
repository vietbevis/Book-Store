* Database : sử dụng mySQL, file tạo database bookstore.
      - Kết nối ở file src/controller/JDBCUntil.java
  
* Phần đăng nhập :
    - Chọn khách hàng có 2 trường hợp xảy ra :
        + Đã có thông tin của khách hàng đó trong db thì vào thẳng store
        + Chưa có thông tin khách hàng trong db thì chuyển sang phần đăng kí, xong sẽ vào thẳng store
        + Phần đăng kí sẽ có mục nhập mã nhân viên tiếp đón mình nhân viên này sẽ xử lí tất cả các dịch vụ của khách hàng mới này 
    - Với lựa chọn là nhân viên thì tương tự trên
    - Chọn thoát là thoát hẳn chương trình 
    - Điều kiện khách hàng/nhân viên phải nhớ mã khách hàng/nhân viên của mình tương tự như username và password
    - Đã xử lí trường hợp người dùng nhập sai kiểu dữ liệu yêu cầu, nhập số âm nếu nhập sai sẽ bắt nhập lại
      
* Phần store :
    - Có 2 menu chính là khách hàng và nhân viên (xem trong file src/model/Menu.java)
    - Nhân viên :
        + CN1 : Thêm sách vào kho : Nhập mã sách nếu sách này hiện đang có trong db thì sẽ nhập số lượng để thêm vào nếu mã sách nhập vào chưa có thông tin trong db thì sẽ phải nhập đầy đủ thông tin của sách đó (tên sách , tác giả, thể loại mô tả giá nhập giá bán, ...) sau khi thêm thành công db tự động cập 
        + CN2 : Xuất kho : Nhân viên có quyên xuất kho ra cho khách lẻ không đăng kí thông tin vào cửa hàng
        + CN3 : Thống kê sách còn lại trong kho : tự động xóa các sản phẩm có số lượng = 0 khỏi db đồng thời cũng xóa các tác giả và thể loại mà không có sản phẩm nào của tác giả, thể loại đó
        + CN4 : Hiển thị toàn bộ danh sách các đơn hàng được khách hàng đặt
        + CN5 : Cập nhật trạng thái đơn hàng : Khi đơn hàng được khách hàng đặt mua sẽ mặc định trạng thái là "Đang xử lý" khi giao hàng xong nhân viên sẽ cập nhật mặc định khi cập nhật sẽ là "Đã giao"
        + CN6 : Thống kê lợi nhuận : dựa trên tất cả các đơn hàng ở trạng thái "Đã giao"
        + Thoát : sẽ thoát về "Phần đăng nhập"
     
    - Khách hàng :
        + CN1 : Hiển thị toàn bộ số sách còn lại trong kho
        + CN2 : Thêm vào giỏ hàng (Giỏ hàng sẽ không đc lưu vào db) : Nhập mã sách hoặc tên sách, số lượng muốn thêm, sách nào đã có trong giỏ hàng thì không thể thêm vào nữa 
        + CN3 : Hiển thị toàn bộ sách vừa thêm vào giỏ hàng lúc này sẽ hiển thị menu giỏ hàng gồm 4 chức năng xóa 1 sản phẩm, xóa toàn bộ sản phẩm và đặt mua toàn bộ sản phẩm trong giỏ hàng, chức năng thoát sẽ chỉ thoát khỏi giỏ hàng mà không dừng ctrinh
        + CN4 : Hiển thị toàn bộ các đơn hàng của khách hàng này trong trạng thái "Chờ xử lý" lúc này sẽ hiện menu đơn hàng gồm 2 chức năng là Hủy đơn hàng và thoát khỏi trang đơn hàng
        + CN5 : Thoát về phần đăng nhập

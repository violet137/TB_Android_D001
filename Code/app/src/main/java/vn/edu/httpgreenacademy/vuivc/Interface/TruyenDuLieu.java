package vn.edu.httpgreenacademy.vuivc.Interface;

public interface TruyenDuLieu {
   public void GetSoluongVideo(int soluong);
   public void GetDuLieuEditProfile(String tenuser,String ngaysinh,String gioitinh);
   public void GetSoluongFollower(int soluong);
   public void GetSoluongFollowing(int soluong);
}

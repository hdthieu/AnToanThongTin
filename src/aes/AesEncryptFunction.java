package aes;

import java.util.Arrays;

import keyAlgorithm.KeyAlFunctions;

public class AesEncryptFunction {

    // Hàm mã hóa bằng giải thuật AES
    public static int[] AesEncrypt(int[] state, int[] key) {
        // Thực hiện Mở Rộng Khóa trên khóa đã cho
        int[] w = KeyAlFunctions.KeyExpansion(key);
        // Lấy 4 chỉ số đầu tiên từ mảng mở rộng và thực hiện AddRoundKey
        state = KeyAlFunctions.AddRoundKey(state, Arrays.copyOfRange(w, 0, 4));

        // Lặp qua 9 vòng mã hóa
        for (int i = 1; i <= 9; i++) {
            state = KeyAlFunctions.SubBytes(state);
            state = KeyAlFunctions.ShiftRows(state);
            state = KeyAlFunctions.MixColumns(state);
            // Thực hiện AddRoundKey trong mỗi vòng dùng các chỉ số tương ứng trong mảng mở rộng
            state = KeyAlFunctions.AddRoundKey(state, Arrays.copyOfRange(w, i * 4, i * 4 + 4));
//            System.out.println("Vòng" + i);
//            KeyAlFunctions.ShowMatrix(state);
        }

        // Vòng 10 - hoạt động SubBytes, ShiftRows và AddRoundKey
        state = KeyAlFunctions.SubBytes(state);
        state = KeyAlFunctions.ShiftRows(state);
        state = KeyAlFunctions.AddRoundKey(state, Arrays.copyOfRange(w, 10 * 4, 10 * 4 + 4));

        System.out.printf("\nRound 10: \n");
        KeyAlFunctions.ShowMatrix(state);
        // Trả về kết quả
        int[] kq = new int[4];
        kq = state;
        return kq;
    }

    public static void main(String[] args) {
        int w0 = 0x2b7e1516, w1 = 0x28aed2a6, w2 = 0xabf71588, w3 = 0x09cf4f3c;
        int state[] = new int[4];
        state[0] = 0x3243f6a8;
        state[1] = 0x885a308d;
        state[2] = 0x313198a2;
        state[3] = 0xe0370734;
        
//        KeyAlFunctions.RotWord(w3);
//        KeyAlFunctions.SubWord(w3);
        
        int key[] = {w0, w1, w2, w3};
       state =  KeyAlFunctions.AddRoundKey(state, key);
         state = KeyAlFunctions.SubBytes(state);
         state =  KeyAlFunctions.ShiftRows(state);
         state = KeyAlFunctions.MixColumns(state);
        
//        int[] C = AesEncrypt(state, key);
//        System.out.printf("\n\nBan ma: \n");
//        KeyAlFunctions.ShowMatrix(C);
    }

}

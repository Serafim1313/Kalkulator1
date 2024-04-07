import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        char c = ' ';
        int a = 0;
        int lenght = str1.length();
        int j =0;
        char znak = ' ';
        boolean arab = false;
        boolean rim = false;
        int result1 = 0;
        for (int i = 0; i<lenght; i++) {
           c = str1.charAt(i);
            switch (c) {
                case '+': {

                a++;
                j = i;
                znak = c;
                break; }
                case '-': {

                    a++;
                    j = i;
                    znak = c;
                    break; }
                case '*': {

                    a++;
                    j = i;
                    znak = c;
                    break; }
                case '/': {

                    a++;
                    j = i;
                    znak = c;
                    break; }
            }
        }

        if (a>1) {System.out.println("Mnogo znakov");
            System. exit(0);
            }
        if (a==0) {System.out.println("Net znakov");
            System. exit(0);
        }

        char[] chars1 = new char[lenght];
        char[] chars2 = new char[lenght];
                for (int i=0 ; i<lenght; i++) {
                    chars1[i] = ' ';
                    chars2[i] = ' ';
                }
        str1.getChars(0,j,chars1,  0 );
        str1.getChars(j+1,str1.length(),chars2,  0 );
       String str2 = new String(chars1);
        String str4 = new String(chars2);
      String str3 = str2.trim();
        String str5 = str4.trim();


        Chisla chislo1 = new Chisla();
        Chisla chislo2 = new Chisla();

        int chisloInt1 = 0;
        int chisloInt2 = 0;

if (chislo1.ProverkaInt(str3) & chislo2.ProverkaInt(str5)) {
    arab = true;
    chisloInt1 = chislo1.Perevod(str3);
    chisloInt2 = chislo2.Perevod(str5);
} else {
        if (chislo1.ProverkaRim(str3) & chislo2.ProverkaRim(str5)) {
            rim = true;
            chisloInt1 = chislo1.PerevodRim(str3);
            chisloInt2 = chislo2.PerevodRim(str5);
        }

else { System.out.println("Net Sovpadenya Chisel ili rimskie bolshie");
        System. exit(0);

        }}

    if ((chisloInt1>10 | chisloInt1<1) | (chisloInt2>10 | chisloInt2<1)) {
        System.out.println("Chisla Ne Te");
        System. exit(0);
    }
  if (arab & (znak=='+')) {
        result1 = chisloInt1 + chisloInt2;
      System.out.println(result1);
         }
        if (arab & (znak=='-')) {
            result1 = chisloInt1 - chisloInt2;
            System.out.println(result1);
        }
        if (arab & (znak=='*')) {
            result1 = chisloInt1 * chisloInt2;
            System.out.println(result1);
        }
        if (arab & (znak=='/')) {
            result1 = chisloInt1 / chisloInt2;
            System.out.println(result1);
        }

        if (rim & (znak=='+')) {
            result1 = chisloInt1 + chisloInt2;
            System.out.println(chislo1.RimPerevod(result1));
        }
        if (rim & (znak=='-')) {
            result1 = chisloInt1 - chisloInt2;
            if (result1>0){
                System.out.println(chislo1.RimPerevod(result1)); }
            else { System.out.println("result otricatelniy u rima");

            }
        }
        if (rim & (znak=='*')) {
            result1 = chisloInt1 * chisloInt2;
            System.out.println(chislo1.RimPerevod(result1));
        }
        if (rim & (znak=='/')) {
            result1 = chisloInt1 / chisloInt2;
            if (result1>0){
                System.out.println(chislo1.RimPerevod(result1)); }
            else { System.out.println("result 0 u rima");}
        }

}}

class Chisla{
    String vvod;
    int vivod;

    int Perevod(String vvod){
       int dlina = vvod.length();
       char[] vvodchar = new char[dlina];
       for ( int i = 0; i<dlina; i++ ) {
           vvodchar[i] = ' ';
        }
       vvod.getChars(0, dlina,vvodchar, 0);
       int vivod = 0;
       for (int i = 0; i<dlina; i++ ) {
           int j = dlina - i -1;
           double stepen1 = Math.pow(10.0, j);
           int stepen = (int) Math.round(stepen1);
           vivod = vivod + Character.getNumericValue(vvodchar[i])*stepen;
       }
       return vivod;
    }
    boolean ProverkaInt(String vvod){
        boolean result1 = false;
        int dlina = vvod.length();
        char[] vvodchar = new char[dlina];
        for ( int i = 0; i<dlina; i++ ) {
            vvodchar[i] = ' ';
        }
        vvod.getChars(0, dlina,vvodchar, 0);
        int result2 = 0;
        for ( int i=0; i<dlina; i++) {
            switch(vvodchar[i]){
            case '0':
                result2++;
                break;
                case '9':
                    result2++;
                    break;
                case '1':
                    result2++;
                    break;
                    case '2':
                    result2++;
                    break;
                    case '3':
                    result2++;
                    break;
                    case '4':
                    result2++;
                    break;
                    case '5':
                    result2++;
                    break;
                    case '6':
                    result2++;
                    break;
                    case '7':
                    result2++;
                    break;
                    case '8':
                    result2++;
                    break;
            default: result1 = false;
        }
        }
        if (result2==dlina) {
            result1 = true;
        }
        return result1;
    }
boolean ProverkaRim(String vvod){
        boolean result1 = false;
        String vvod1 = vvod.toLowerCase();
        int dlina = vvod.length();
        int result2 = 0;
        char c;
        for ( int i=0; i<dlina; i++){
            c = vvod1.charAt(i);
            switch (c) {
                case 'i':
                    result2++;
                    break;
                case 'v':
                    result2++;
                    break;
                case 'x':
                    result2++;
                    break;
            }

        }
    if (result2==dlina) {
        result1 = true;
    }

        return result1;
}
int PerevodRim(String vvod){
        int result1 = 0;
    String vvod1 = vvod.toLowerCase();
        switch (vvod1){
            case "i":
                result1 = 1;
                break;
            case "ii":
                result1 = 2;
                break;
            case "iii":
                result1 = 3;
                break;
            case "iv":
                result1 = 4;
                break;
            case "v":
                result1 = 5;
                break;
            case "vi":
                result1 = 6;
                break;
            case "vii":
                result1 = 7;
                break;
            case "viii":
                result1 = 8;
                break;
            case "ix":
                result1 = 9;
                break;
            case "x":
                result1 = 10;
                break;
            default: result1 = 0;
        }
        return result1;
}
String RimPerevod(int result){
        String otvet = "";
        switch (result) {
        case 1:
            otvet = "i";
            break;
        case 2:
            otvet = "ii";
            break;
        case 3:
            otvet = "iii";
            break;
        case 4:
            otvet = "iv";
            break;
        case 5:
            otvet = "v";
            break;
        case 6:
            otvet = "vi";
            break;
        case 7:
            otvet = "vii";
            break;
        case 8:
            otvet = "viii";
            break;
        case 9:
            otvet = "ix";
            break;
        case 10:
            otvet = "x";
            break;
        case 11:
            otvet = "xi";
            break;
        case 12:
            otvet = "xii";
            break;
        case 13:
            otvet = "xiii";
            break;
        case 14:
            otvet = "xiv";
            break;
        case 15:
            otvet = "xv";
            break;
        case 16:
            otvet = "xvi";
            break;
        case 17:
            otvet = "xvii";
            break;
        case 18:
            otvet = "xviii";
            break;
        case 19:
            otvet = "xix";
            break;
        case 20:
            otvet = "xx";
            break;
        case 21:
            otvet = "xxi";
            break;
        case 22:
            otvet = "xxii";
            break;
        case 23:
            otvet = "xxiii";
            break;
        case 24:
            otvet = "xxiv";
            break;
        case 25:
            otvet = "xxv";
            break;
        case 26:
            otvet = "xxvi";
            break;
        case 27:
            otvet = "xxvii";
            break;
        case 28:
            otvet = "xxviii";
            break;
        case 29:
            otvet = "xxix";
            break;
        case 30:
            otvet = "xxx";
            break;
        case 31:
            otvet = "xxxi";
            break;
        case 32:
            otvet = "xxxii";
            break;
        case 33:
            otvet = "xxxiii";
            break;
        case 34:
            otvet = "xxxiv";
            break;
        case 35:
            otvet = "xxxv";
            break;
        case 36:
            otvet = "xxxvi";
            break;
        case 37:
            otvet = "xxxvii";
            break;
        case 38:
            otvet = "xxxviii";
            break;
        case 39:
            otvet = "xxxix";
            break;
        case 40:
            otvet = "xl";
            break;
        case 41:
            otvet = "xli";
            break;
        case 42:
            otvet = "xlii";
            break;
        case 43:
            otvet = "xliii";
            break;
        case 44:
            otvet = "xliv";
            break;
        case 45:
            otvet = "xlv";
            break;
        case 46:
            otvet = "xlvi";
            break;
        case 47:
            otvet = "xlvii";
            break;
        case 48:
            otvet = "xlviii";
            break;
        case 49:
            otvet = "il";
            break;
        case 50:
            otvet = "l";
            break;
        case 51:
            otvet = "li";
            break;
        case 52:
            otvet = "lii";
            break;
        case 53:
            otvet = "liii";
            break;
        case 54:
            otvet = "liv";
            break;
        case 55:
            otvet = "lv";
            break;
            case 56:
            otvet = "lvi";
            break;
            case 57:
            otvet = "lvii";
            break;
        case 58:
            otvet = "lviii";
            break;
        case 59:
            otvet = "lix";
            break;
        case 60:
            otvet = "lx";
            break;
        case 61:
            otvet = "lxi";
            break;
        case 62:
            otvet = "lxii";
            break;
        case 63:
            otvet = "lxiii";
            break;
        case 64:
            otvet = "lxiv";
            break;
        case 65:
            otvet = "lxv";
            break;
        case 66:
            otvet = "lxvi";
            break;
        case 67:
            otvet = "lxvii";
            break;
        case 68:
            otvet = "lxviii";
            break;
        case 69:
            otvet = "lxix";
            break;
        case 70:
            otvet = "lxx";
            break;
        case 71:
            otvet = "lxxi";
            break;
        case 72:
            otvet = "lxxii";
            break;
        case 73:
            otvet = "lxxiii";
            break;
        case 74:
            otvet = "lxxiv";
            break;
        case 75:
            otvet = "lxxv";
            break;
        case 76:
            otvet = "lxxvi";
            break;
        case 77:
            otvet = "lxxvii";
            break;
        case 78:
            otvet = "lxxviii";
            break;
        case 79:
            otvet = "lxxix";
            break;
        case 80:
            otvet = "lxxx";
            break;
        case 81:
            otvet = "lxxxi";
            break;
        case 82:
            otvet = "lxxxii";
            break;
        case 83:
            otvet = "lxxxiii";
            break;
        case 84:
            otvet = "lxxxiv";
            break;
        case 85:
            otvet = "lxxxv";
            break;
        case 86:
            otvet = "lxxxvi";
            break;
        case 87:
            otvet = "lxxxvii";
            break;
        case 88:
            otvet = "lxxxviii";
            break;
        case 89:
            otvet = "lxxxix";
            break;
        case 90:
            otvet = "xc";
            break;
        case 91:
            otvet = "xci";
            break;
        case 92:
            otvet = "xcii";
            break;
        case 93:
            otvet = "xciii";
            break;
        case 94:
            otvet = "xciv";
            break;
        case 95:
            otvet = "xcv";
            break;
        case 96:
            otvet = "xcvi";
            break;
        case 97:
            otvet = "xcvii";
            break;
        case 98:
            otvet = "xcviii";
            break;
        case 99:
            otvet = "xcix";
            break;
        case 100:
            otvet = "c";
            break;


    }
    String otvet1 = otvet.toUpperCase();
        return otvet1;
}
}
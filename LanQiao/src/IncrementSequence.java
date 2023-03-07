/**
 * <a href="https://www.lanqiao.cn/problems/819/learning/?page=1&first_category_id=1&sort=students_count">
 * 递增序列
 * </a>
 *
 * @author ginga
 * @since 3/3/2023 上午10:49
 */
public class IncrementSequence {
    public static void main(String[] args) {
        String s = "VLPWJVVNNZSWFGHSFRBCOIJTPYNEURPIGKQGPSXUGNELGRVZAG" +
                "SDLLOVGRTWEYZKKXNKIRWGZWXWRHKXFASATDWZAPZRNHTNNGQF" +
                "ZGUGXVQDQAEAHOQEADMWWXFBXECKAVIGPTKTTQFWSWPKRPSMGA" +
                "BDGMGYHAOPPRRHKYZCMFZEDELCALTBSWNTAODXYVHQNDASUFRL" +
                "YVYWQZUTEPFSFXLTZBMBQETXGXFUEBHGMJKBPNIHMYOELYZIKH" +
                "ZYZHSLTCGNANNXTUJGBYKUOJMGOGRDPKEUGVHNZJZHDUNRERBU" +
                "XFPTZKTPVQPJEMBHNTUBSMIYEGXNWQSBZMHMDRZZMJPZQTCWLR" +
                "ZNXOKBITTPSHEXWHZXFLWEMPZTBVNKNYSHCIQRIKQHFRAYWOPG" +
                "MHJKFYYBQSDPOVJICWWGGCOZSBGLSOXOFDAADZYEOBKDDTMQPA" +
                "VIDPIGELBYMEVQLASLQRUKMXSEWGHRSFVXOMHSJWWXHIBCGVIF" +
                "GWRFRFLHAMYWYZOIQODBIHHRIIMWJWJGYPFAHZZWJKRGOISUJC" +
                "EKQKKPNEYCBWOQHTYFHHQZRLFNDOVXTWASSQWXKBIVTKTUIASK" +
                "PEKNJFIVBKOZUEPPHIWLUBFUDWPIDRJKAZVJKPBRHCRMGNMFWW" +
                "CGZAXHXPDELTACGUWBXWNNZNDQYYCIQRJCULIEBQBLLMJEUSZP" +
                "RWHHQMBIJWTQPUFNAESPZHAQARNIDUCRYQAZMNVRVZUJOZUDGS" +
                "PFGAYBDEECHUXFUZIKAXYDFWJNSAOPJYWUIEJSCORRBVQHCHMR" +
                "JNVIPVEMQSHCCAXMWEFSYIGFPIXNIDXOTXTNBCHSHUZGKXFECL" +
                "YZBAIIOTWLREPZISBGJLQDALKZUKEQMKLDIPXJEPENEIPWFDLP" +
                "HBQKWJFLSEXVILKYPNSWUZLDCRTAYUUPEITQJEITZRQMMAQNLN" +
                "DQDJGOWMBFKAIGWEAJOISPFPLULIWVVALLIIHBGEZLGRHRCKGF" +
                "LXYPCVPNUKSWCCGXEYTEBAWRLWDWNHHNNNWQNIIBUCGUJYMRYW" +
                "CZDKISKUSBPFHVGSAVJBDMNPSDKFRXVVPLVAQUGVUJEXSZFGFQ" +
                "IYIJGISUANRAXTGQLAVFMQTICKQAHLEBGHAVOVVPEXIMLFWIYI" +
                "ZIIFSOPCMAWCBPKWZBUQPQLGSNIBFADUUJJHPAIUVVNWNWKDZB" +
                "HGTEEIISFGIUEUOWXVTPJDVACYQYFQUCXOXOSSMXLZDQESHXKP" +
                "FEBZHJAGIFGXSMRDKGONGELOALLSYDVILRWAPXXBPOOSWZNEAS" +
                "VJGMAOFLGYIFLJTEKDNIWHJAABCASFMAKIENSYIZZSLRSUIPCJ" +
                "BMQGMPDRCPGWKTPLOTAINXZAAJWCPUJHPOUYWNWHZAKCDMZDSR" +
                "RRARTVHZYYCEDXJQNQAINQVDJCZCZLCQWQQIKUYMYMOVMNCBVY" +
                "ABTCRRUXVGYLZILFLOFYVWFFBZNFWDZOADRDCLIRFKBFBHMAXX";
        char[][] matrix = new char[35][50];
        int k = 0, count = 0;

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 50; j++) {
                matrix[i][j] = s.charAt(k++);
            }
        }

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 50; j++) {
                // 同一行
                for (int l = j + 1; l < 50; l++)
                    if (matrix[i][j] < matrix[i][l])
                        count++;

                // 同一列
                for (int l = i + 1; l < 30; l++)
                    if (matrix[i][j] < matrix[l][j])
                        count++;

                // 正对角线
                for (int l = i + 1, m = j + 1; l < 30 && m < 50; l++, m++)
                    if (matrix[i][j] < matrix[l][m])
                        count++;

                // 反对角线
                for (int l = i + 1, m = j - 1; l < 30 && m >= 0; l++, m--)
                    if (matrix[i][j] != matrix[l][m])
                        count++;


            }
        }

        System.out.println(count);

    }
}

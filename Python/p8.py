value = ("73167176531330624919225119674426574742355349194934969835203127" +
"74506326239578318016984801869478851843858615607891129494954595017379583" +
"31952853208805511125406987471585238630507156932909632952274430435576689" +
"66489504452445231617318564030987111217223831136222989342338030813533627" +
"66142828064444866452387493035890729629049156044077239071381051585930796" +
"08667017242712188399879790879227492190169972088809377665727333001053367" +
"88122023542180975125454059475224352584907711670556013604839586446706324" +
"41572215539753697817977846174064955149290862569321978468622482839722413" +
"75657056057490261407972968652414535100474821663704844031998900088952434" +
"50658541227588666881164271714799244429282308634656748139191231628245861" +
"78664583591245665294765456828489128831426076900422421902267105562632111" +
"11093705442175069416589604080719840385096245544436298123098787992724428" +
"49091888458015616609791913387549920052406368991256071760605886116467109" +
"40507754100225698315520005593572972571636269561882670428252483600823257" +
"530420752963450")

max_product = 0

for i in range(0, 995):
    sub_value = value[i:(i+5)]

    product = 1
    for j in range(0, 5):
        product *= int(sub_value[j])

    if product > max_product:
        max_product = product

print max_product

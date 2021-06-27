import SwiftUI

struct InputField_Previews: PreviewProvider {
    
    static var previews: some View {
        let text = Binding<String> (get: { "Text"}, set:{ $0 })
        InputField(text: text, hint: "Hint", label: "Label", type: .name)
    }
}

struct InputField: View {
    
    var text: Binding<String>
    var hint: String
    var label: String
    var type : UITextContentType
    
    var body: some View {
        VStack (alignment: .leading){
            Text(label)
                .font(.callout)
                .bold()
            
            TextField(hint, text: text)
                .textFieldStyle(PlainTextFieldStyle())
                .padding()
                .overlay(RoundedRectangle(cornerRadius: 5).stroke(Color("lightGrey")))
        }
    }
}



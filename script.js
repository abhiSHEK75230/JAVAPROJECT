// Initialize CodeMirror
const htmlEditor = CodeMirror.fromTextArea(document.getElementById('htmlEditor'), {
  lineNumbers: true,
  mode: "htmlmixed",
  theme: "default"
});

const cssEditor = CodeMirror.fromTextArea(document.getElementById('cssEditor'), {
  lineNumbers: true,
  mode: "css",
  theme: "default"
});

function updatePreview() {
  const html = htmlEditor.getValue();
  const css = cssEditor.getValue();
  const previewFrame = document.getElementById('previewFrame');
  const doc = previewFrame.contentDocument || previewFrame.contentWindow.document;
  doc.open();
  doc.write(`
    <style>${css}</style>
    ${html}
  `);
  doc.close();
}

htmlEditor.on('change', updatePreview);
cssEditor.on('change', updatePreview);

window.onload = updatePreview;

function loadArt(name) {
  if (name === 'smiley') {
    htmlEditor.setValue(`<div class='smiley'></div>`);
    cssEditor.setValue(`.smiley {
  width: 100px;
  height: 100px;
  background: yellow;
  border-radius: 50%;
  position: relative;
}
.smiley::before,
.smiley::after {
  content: '';
  position: absolute;
  width: 20px;
  height: 20px;
  background: black;
  top: 25px;
  border-radius: 50%;
}
.smiley::before {
  left: 20px;
}
.smiley::after {
  right: 20px;
}`);
  }
  updatePreview();
}
